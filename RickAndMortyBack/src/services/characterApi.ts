import axios from 'axios';

export const characterApi = async (id: any) => {
  try {
    console.log(id);
    
    const response = await axios.get(
      `https://rickandmortyapi.com/api/character/${id}`
    );
    console.log(response.data);
    
    return response.data;
  } catch (error) {
    return error;
  }
};
