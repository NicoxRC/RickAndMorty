import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  currentPageUrl: 'https://rickandmortyapi.com/api/character',
  currentPage: 1,
};

export const paginationSlice = createSlice({
  name: 'pagination',
  initialState,
  reducers: {
    url: (state, action) => {
      state.currentPageUrl = action.payload;
    },
    setCurrentPage: (state, action) => {
      state.currentPage = action.payload;
    },
  },
});

export const { url, setCurrentPage } = paginationSlice.actions;
export default paginationSlice.reducer;
