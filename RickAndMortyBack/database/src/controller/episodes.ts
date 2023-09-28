import connection from '../connection';
import type { Request, Response } from 'express';
import type { EpisodesInterface } from '../interfaces/episodes';

export const epidosesList = async (
  req: Request,
  res: Response
): Promise<void> => {
  try {
    const response: EpisodesInterface[] = await connection.Episode.find();

    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};

export const episode = async (req: Request, res: Response): Promise<void> => {
  try {
    const { id } = req.params;
    const response = await connection.Episode.findById(id).populate(
      'characters',
      ['_id', 'name']
    );

    res.status(200).json(response);
  } catch (error: unknown) {
    error instanceof Error
      ? res.status(400).json({ error: error.message })
      : null;
  }
};
