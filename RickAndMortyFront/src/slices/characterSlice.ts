import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { charactersApi } from '../services/charactersApi';

const initialState = {
  charactersApi: [],
};

export const getCharactersApi: any = createAsyncThunk(
  'characters/getCharacterApi',
  async (_, { dispatch }) => {
    const response = await charactersApi();
    dispatch(getCharacters(response.results));
  }
);

export const characterSlice = createSlice({
  name: 'characters',
  initialState,
  reducers: {
    getCharacters: (state, action) => {
      state.charactersApi = action.payload;
    },
  },
});

export const { getCharacters } = characterSlice.actions;
export default characterSlice.reducer;
