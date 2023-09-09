import connection from '../connection';
import type { Request, Response } from 'express';
import type { LocationsInterface } from '../interfaces/locations';

export const locationsList = async (
  req: Request,
  res: Response
): Promise<void> => {
  try {
    const response: LocationsInterface[] =
      await connection.Location.find().populate('residents', ['_id', 'name']);

    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
