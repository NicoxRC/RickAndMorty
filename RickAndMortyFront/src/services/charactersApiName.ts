import axios from 'axios';

export const characterApiName = async (name: string) => {
  try {
    const response = await axios.get(
      `https://rickandmortyapi.com/api/character/?name=${name}`
    );
    return response.data;
  } catch (error) {
    return error;
  }
};
