import { PayloadAction, createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { getCharactersList } from '../services/getCharacters';
import { getCharactersFilter } from '../services/getCharactersFilter';
import type {
  CharactersInterface,
  InitialStateCharactersInterface,
} from '../interfaces/characters';
import type { FilterType } from '../types/filter';

const initialState: InitialStateCharactersInterface = {
  characters: [],
  filterCharacters: [],
};

export const getAllCharacters = createAsyncThunk(
  'characters/getCharacters',
  async (_, { dispatch }) => {
    const res: CharactersInterface[] = await getCharactersList();
    dispatch(allCharacters(res));
  }
);

export const CharactersFilter = createAsyncThunk(
  'characters/filterCharacters',
  async (filters: FilterType, { dispatch }) => {
    const res: CharactersInterface[] = await getCharactersFilter(filters);
    dispatch(filterCharacters(res));
  }
);

export const characterSlice = createSlice({
  name: 'characters',
  initialState,
  reducers: {
    allCharacters: (state, action: PayloadAction<CharactersInterface[]>) => {
      state.characters = action.payload;
    },
    filterCharacters: (state, action: PayloadAction<CharactersInterface[]>) => {
      state.filterCharacters = action.payload;
    },
  },
});

export const { allCharacters, filterCharacters } = characterSlice.actions;
export default characterSlice.reducer;
