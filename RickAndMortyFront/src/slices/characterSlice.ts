import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  characters: [],
};

export const characterSlice = createSlice({
  name: 'characters',
  initialState,
  reducers: {
    showCharacters: (state, action) => {
      state.characters = action.payload;
    },
  },
});

export const { showCharacters } = characterSlice.actions;
export default characterSlice.reducer;
