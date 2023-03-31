import type { RickAndMortyApiInterface } from './../utils/rickAndMortyApiInterface';
import axios from 'axios';

export const charactersApi = async (
  url: string
): Promise<RickAndMortyApiInterface> => {
  try {
    const { data } = await axios.get<RickAndMortyApiInterface>(url);
    return data;
  } catch (error: any) {
    return error;
  }
};
