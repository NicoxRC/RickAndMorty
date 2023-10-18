import axios from 'axios';
import type { CharactersInterface } from '../interfaces/characters';

export const getCharactersList = async (): Promise<CharactersInterface[]> => {
  try {
    const { data } = await axios.get<CharactersInterface[]>('/characters');
    return data;
  } catch (error: unknown) {
    if (error instanceof TypeError) {
      throw new Error(error.message);
    } else {
      throw new Error('Unknown error');
    }
  }
};
