import axios from 'axios';
import type { Request, Response } from 'express';
import type { CharactersInterface } from '../interfaces/characters';

export = async (req: Request, res: Response): Promise<void> => {
  try {
    const { data } = await axios.get<CharactersInterface[]>(
      'http://localhost:3005/characters'
    );
    res.status(200).json(data);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
