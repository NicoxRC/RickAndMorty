import { PayloadAction, createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { getCharactersList } from '../services/getCharacters';
import type { CharactersInterface } from '../interfaces/characters';

interface initialStateInterface {
  characters: CharactersInterface[];
  showCharacters: CharactersInterface[];
}

const initialState: initialStateInterface = {
  characters: [],
  showCharacters: [],
};

export const getAllCharacters = createAsyncThunk(
  'characters/getCharacters',
  async (_, { dispatch }) => {
    const res: CharactersInterface[] = await getCharactersList();
    dispatch(allCharacters(res));
  }
);

export const characterSlice = createSlice({
  name: 'characters',
  initialState,
  reducers: {
    allCharacters: (state, action: PayloadAction<CharactersInterface[]>) => {
      state.characters = action.payload;
    },
    showCharacters: (state, action: PayloadAction<CharactersInterface[]>) => {
      state.showCharacters = action.payload;
    },
  },
});

export const { allCharacters, showCharacters } = characterSlice.actions;
export default characterSlice.reducer;
