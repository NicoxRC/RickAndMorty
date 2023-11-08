import { PayloadAction, createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { getCharactersList } from '../services/getCharacters';
import { getCharactersFilter } from '../services/getCharactersFilter';
import type {
  CharactersInterface,
  InitialStateCharactersInterface,
  PayloadShowCharactersInterface,
} from '../interfaces/characters';
import type { FilterType } from '../types/filter';

const initialState: InitialStateCharactersInterface = {
  characters: [],
  filterCharacters: [],
  showCharacters: [],
};

export const getAllCharacters = createAsyncThunk(
  'characters/getCharacters',
  async (_, { dispatch }) => {
    const res: CharactersInterface[] = await getCharactersList();
    dispatch(setAllCharacters(res));
  }
);

export const CharactersFilter = createAsyncThunk(
  'characters/filterCharacters',
  async (filters: FilterType, { dispatch }) => {
    const res: CharactersInterface[] = await getCharactersFilter(filters);
    dispatch(setFilterCharacters(res));
  }
);

export const characterSlice = createSlice({
  name: 'characters',
  initialState,
  reducers: {
    setAllCharacters: (state, action: PayloadAction<CharactersInterface[]>) => {
      state.characters = action.payload;
      state.filterCharacters = action.payload;
    },
    setFilterCharacters: (
      state,
      action: PayloadAction<CharactersInterface[]>
    ) => {
      state.filterCharacters = action.payload;
    },
    setShowCharacters: (
      state,
      action: PayloadAction<PayloadShowCharactersInterface>
    ) => {
      state.showCharacters = action.payload.characters?.slice(
        action.payload.currentPage * action.payload.pageSize -
          action.payload.pageSize,
        action.payload.currentPage * action.payload.pageSize
      );
    },
  },
});

export const { setAllCharacters, setFilterCharacters, setShowCharacters } =
  characterSlice.actions;
export default characterSlice.reducer;
