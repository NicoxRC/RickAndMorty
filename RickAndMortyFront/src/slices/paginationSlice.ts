import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  currentPageUrl: 'https://rickandmortyapi.com/api/character',
};

export const paginationSlice = createSlice({
  name: 'pagination',
  initialState,
  reducers: {
    url: (state, action) => {
      state.currentPageUrl = action.payload;
    },
  },
});

export const { url } = paginationSlice.actions;
export default paginationSlice.reducer;
