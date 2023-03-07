import axios from 'axios';

export const characterApiName = async (name: unknown) => {
  console.log(name);

  try {
    if (typeof name === 'string') {
      console.log(name);

      const response = await axios.get(
        `https://rickandmortyapi.com/api/character/?name=${name}`
      );
      return response.data;
    }
  } catch (error) {
    return error;
  }
};
