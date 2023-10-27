import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  currentPageUrl: '',
  currentPage: 1,
};

export const paginationSlice = createSlice({
  name: 'pagination',
  initialState,
  reducers: {
    url: (state, action) => {
      state.currentPageUrl = action.payload;
    },
    urlFiltered: (state, action) => {
      let filterString: string = '';
      for (const filter in action.payload.filters) {
        filterString += `&${filter}=${action.payload.filters[filter]}`;
      }
      state.currentPageUrl = '' + filterString;
    },
    setCurrentPage: (state, action) => {
      state.currentPage = action.payload;
    },
  },
});

export const { url, urlFiltered, setCurrentPage } = paginationSlice.actions;
export default paginationSlice.reducer;
