import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  filtersType: {},
};

export const filterSlice = createSlice({
  name: 'filters',
  initialState,
  reducers: {
    filterState: (state, action) => {
      state.filtersType = {
        ...state.filtersType,
        [action.payload.type]: action.payload.filter,
      };
    },
  },
});

export const { filterState } = filterSlice.actions;
export default filterSlice.reducer;
