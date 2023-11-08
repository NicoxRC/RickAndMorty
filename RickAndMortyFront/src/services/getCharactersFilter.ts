import axios from 'axios';
import type { CharactersInterface } from '../interfaces/characters';
import type { FilterType } from '../types/filter';

export const getCharactersFilter = async (
  filters: FilterType
): Promise<CharactersInterface[]> => {
  try {
    const params = new URLSearchParams(filters);
    const { data } = await axios.get<CharactersInterface[]>(
      `/characters?${params}`
    );

    return data;
  } catch (error: unknown) {
    if (error instanceof TypeError) {
      throw new Error(error.message);
    } else {
      throw new Error('Unknown error');
    }
  }
};
