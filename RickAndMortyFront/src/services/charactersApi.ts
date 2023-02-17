import axios from 'axios';

export const charactersApi = async () => {
  try {
    const response = await axios.get('http://localhost:3001/characters');
    return response.data;
  } catch (error) {}
};
