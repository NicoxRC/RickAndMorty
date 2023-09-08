import connection from '../connection';
import type { Request, Response } from 'express';
import type { CharactersInterface } from '../interfaces/characters';

export const charactersList = async (
  req: Request,
  res: Response
): Promise<void> => {
  try {
    const response: CharactersInterface[] = await connection.Character.find()
      .populate('origin', ['_id', 'name'])
      .populate('location', ['_id', 'name'])
      // .populate('episode', ['_id', 'name']);
    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
