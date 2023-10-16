import axios from 'axios';
import type { RickAndMortyApiInterface } from '../utils/rickAndMortyApiInterface';

export const getCharactersList = async (): Promise<
  RickAndMortyApiInterface[]
> => {
  console.log('entre');

  try {
    const { data } = await axios.get<RickAndMortyApiInterface[]>('/characters');
    console.log(data);

    return data;
  } catch (error: unknown) {
    if (error instanceof TypeError) {
      throw new Error(error.message);
    } else {
      throw new Error('Unknown error');
    }
  }
};
