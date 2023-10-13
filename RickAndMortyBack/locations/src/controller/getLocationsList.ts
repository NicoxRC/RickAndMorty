import axios from 'axios';
import type { Request, Response } from 'express';
import type { LocationsInterface } from '../interfaces/locations';

export = async (req: Request, res: Response): Promise<void> => {
  try {
    const { data } = await axios.get<LocationsInterface[]>(
      'http://database:3005/locations'
    );
    res.status(200).json(data);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
