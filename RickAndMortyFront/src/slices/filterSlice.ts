import { PayloadAction, createSlice } from '@reduxjs/toolkit';
import type {
  FilterPayloadType,
  InitialStateFiltersType,
} from '../types/filter';

const initialState: InitialStateFiltersType = {
  filterType: {},
};

export const filterSlice = createSlice({
  name: 'filters',
  initialState,
  reducers: {
    filterState: (state, action: PayloadAction<FilterPayloadType>) => {
      state.filterType = {
        ...state.filterType,
        [action.payload.type]: action.payload.filter,
      };
    },
  },
});

export const { filterState } = filterSlice.actions;
export default filterSlice.reducer;
