import axios from 'axios';

export const characterApiName = async (name: string): Promise<unknown> => {
  try {
    const response = await axios.get(
      `https://rickandmortyapi.com/api/character/?name=${name}`
    );
    if (response.data) {
      return `https://rickandmortyapi.com/api/character/?name=${name}`;
    }
  } catch (error) {
    return error;
  }
};
