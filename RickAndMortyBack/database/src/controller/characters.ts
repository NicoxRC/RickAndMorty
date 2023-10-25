import connection from '../connection';
import type { Request, Response } from 'express';
import type { CharactersInterface } from '../interfaces/characters';
import type { FiltersInterfaces } from '../interfaces/filters';

export const charactersList = async (
  req: Request,
  res: Response
): Promise<void> => {
  try {
    const { gender, status, species, type } = req.query;
    let filters: FiltersInterfaces = {};

    if (typeof gender === 'string' && gender.length > 0) {
      filters.gender = gender;
    }
    if (typeof status === 'string' && status.length > 0) {
      filters.status = status;
    }
    if (typeof species === 'string' && species.length > 0) {
      filters.species = species;
    }
    if (typeof type === 'string' && type.length > 0) {
      filters.type = type;
    }

    const response: CharactersInterface[] = await connection.Character.find(
      filters
    ).populate('origin', ['_id', 'name']);

    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};

export const character = async (req: Request, res: Response): Promise<void> => {
  try {
    const { id } = req.params;
    const response = await connection.Character.findById(id)
      .populate('origin', ['_id', 'name'])
      .populate('location', ['_id', 'name']);

    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
