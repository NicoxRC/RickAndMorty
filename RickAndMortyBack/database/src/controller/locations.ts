import connection from '../connection';
import type { Request, Response } from 'express';
import type { LocationsInterface } from '../interfaces/locations';

export const locationsList = async (
  req: Request,
  res: Response
): Promise<void> => {
  try {
    const response: LocationsInterface[] = await connection.Location.find();

    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};

export const location = async (req: Request, res: Response): Promise<void> => {
  try {
    const { id } = req.params;
    const response = await connection.Location.findById(id).populate(
      'residents',
      ['_id', 'name']
    );

    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
