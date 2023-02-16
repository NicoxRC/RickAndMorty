import { Character } from '../models/Character';
import { Request, Response } from 'express';

export const getCharacters = async (req: Request, res: Response) => {
  try {
    const characters = await Character.findAll();
    res.status(200).json(characters);
  } catch (error) {
    res.status(404).json(error);
  }
};

export const getCharacter = async (req: Request, res: Response) => {
  try {
    const { id } = req.params;
    const character = await Character.findByPk(id);
    if (!character) throw new Error('Bad Request.');
    res.status(200).json(character);
  } catch (error) {
    res.status(404).json(error);
  }
};

export const postCharacter = async (req: Request, res: Response) => {
  try {
    const { name, status, species, type, gender, image } = req.body;
    if (!name || !status || !species || !gender)
      throw new Error('Bad Request.');
    const newCharacter = await Character.create({
      name,
      status,
      species,
      type,
      gender,
      image,
    });
    res.status(201).json(newCharacter);
  } catch (error) {
    res.status(400).json(error);
  }
};

export const deleteCharacter = async (req: Request, res: Response) => {
  try {
    const { id } = req.params;
    const character = await Character.findByPk(id);
    if (!character) throw new Error('Bad Request.');
    await character.destroy();
    res.status(202).json({ msg: 'Accepted.' });
  } catch (error) {
    res.status(404).json(error);
  }
};
