import axios from 'axios';
import type { Request, Response } from 'express';
import type { CharactersInterface } from '../interfaces/characters';

export = async (req: Request, res: Response): Promise<void> => {
  try {
    const { gender, status, species, type } = req.query;

    let genderUrl: string = '';
    let statusUrl: string = '';
    let speciesUrl: string = '';
    let typeUrl: string = '';

    if (typeof gender == 'string' && gender.length > 0) {
      genderUrl = gender;
    }
    if (typeof status == 'string' && status.length > 0) {
      statusUrl = status;
    }
    if (typeof species == 'string' && species.length > 0) {
      speciesUrl = species;
    }
    if (typeof type == 'string' && type.length > 0) {
      typeUrl = type;
    }

    const { data } = await axios.get<CharactersInterface[]>(
      `http://database:3005/characters?gender=${genderUrl}&status=${statusUrl}&species=${speciesUrl}&type=${typeUrl}`
    );
    res.status(200).json(data);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
