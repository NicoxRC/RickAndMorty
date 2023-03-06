import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  charactersApi: [],
};

export const characterSlice = createSlice({
  name: 'characters',
  initialState,
  reducers: {
    showCharacters: (state, action) => {
      state.charactersApi = action.payload;
    },
  },
});

export const { showCharacters } = characterSlice.actions;
export default characterSlice.reducer;
