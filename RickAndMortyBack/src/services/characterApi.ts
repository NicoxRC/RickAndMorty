import axios from 'axios';

export const characterApi = async (id: any) => {
  try {
    const response = await axios.get(
      `https://rickandmortyapi.com/api/character/${id}`
    );
    return response.data;
  } catch (error) {
    return error;
  }
};
