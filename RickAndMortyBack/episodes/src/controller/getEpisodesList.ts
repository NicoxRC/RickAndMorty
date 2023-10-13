import axios from 'axios';
import type { Request, Response } from 'express';
import type { EpisodesInterface } from '../interfaces/episodes';

export = async (req: Request, res: Response): Promise<void> => {
  try {
    const { data } = await axios.get<EpisodesInterface[]>(
      'http://database:3005/episodes'
    );
    res.status(200).json(data);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
