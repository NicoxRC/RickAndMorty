import type { RickAndMortyApiInterface } from '../utils/rickAndMortyApiInterface';
import axios from 'axios';

export const characterApiName = async (
  name: string
): Promise<string | undefined> => {
  try {
    const { data } = await axios.get<RickAndMortyApiInterface>(
      `https://rickandmortyapi.com/api/character/?name=${name}`
    );
    if (data) {
      return `https://rickandmortyapi.com/api/character/?name=${name}`;
    }
  } catch (error: any) {
    return error;
  }
};
