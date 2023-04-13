import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  filterType: {},
};

export const filterSlice = createSlice({
  name: 'filters',
  initialState,
  reducers: {
    filterState: (state: any, action) => {
      if (action.payload.type !== action.payload.filter) {
        state.filterType = {
          ...state.filterType,
          [action.payload.type]: action.payload.filter,
        };
      } else {
        if (state.filterType.hasOwnProperty(action.payload.type)) {
          delete state.filterType[action.payload.type];
        }
      }
    },
  },
});

export const { filterState } = filterSlice.actions;
export default filterSlice.reducer;
