import { PayloadAction, createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { getCharactersList } from '../services/characters';
import type { RickAndMortyApiInterface } from '../utils/rickAndMortyApiInterface';

interface initialStateInterface {
  characters: RickAndMortyApiInterface[];
  showCharacters: RickAndMortyApiInterface[];
}

const initialState: initialStateInterface = {
  characters: [],
  showCharacters: [],
};

export const getAllCharacters = createAsyncThunk(
  'characters/getCharacters',
  async (_, { dispatch }) => {
    const res: RickAndMortyApiInterface[] = await getCharactersList();
    dispatch(allCharacters(res));
  }
);

export const characterSlice = createSlice({
  name: 'characters',
  initialState,
  reducers: {
    allCharacters: (
      state,
      action: PayloadAction<RickAndMortyApiInterface[]>
    ) => {
      state.characters = action.payload;
    },
    showCharacters: (
      state,
      action: PayloadAction<RickAndMortyApiInterface[]>
    ) => {
      state.showCharacters = action.payload;
    },
  },
});

export const { allCharacters, showCharacters } = characterSlice.actions;
export default characterSlice.reducer;
