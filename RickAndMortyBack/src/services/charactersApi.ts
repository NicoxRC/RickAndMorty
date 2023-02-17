import axios from 'axios';

export const charactersApi = async () => {
  try {
    const response = await axios.get(
      'https://rickandmortyapi.com/api/character'
    );
    return response.data;
  } catch (error) {
    return error;
  }
};
