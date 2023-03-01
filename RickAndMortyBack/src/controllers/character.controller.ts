import { Request, Response } from 'express';
import { characterApi } from './../services/characterApi';
import { Character } from '../models/Character';
import { charactersApi } from '../services/charactersApi';

export const getCharactersDB = async (req: Request, res: Response) => {
  try {
    const characters = await Character.findAll();
    if (!characters) throw new Error('Not Found.');
    res.status(200).json(characters);
  } catch (error) {
    res.status(404).json(error);
  }
};

export const getCharactersApi = async (req: Request, res: Response) => {
  try {
    const characters = await charactersApi();
    if (!characters) throw new Error('Not Found.');
    res.status(200).json(characters);
  } catch (error) {
    res.status(404).json(error);
  }
};

export const getCharacter = async (req: Request, res: Response) => {
  try {
    const { id } = req.params;
    const regex =
      /^[0-9A-F]{8}-[0-9A-F]{4}-4[0-9A-F]{3}-[89AB][0-9A-F]{3}-[0-9A-F]{12}$/i;
    let character: object | null;
    if (regex.test(id)) {
      character = await Character.findByPk(id);
      if (!character) throw new Error('Bad Request.');
    } else {
      character = await characterApi(id);
      if (!character) throw new Error('Bad Request.');
    }
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
