import characterReducer from '../slices/characterSlice';
import paginationReducer from '../slices/paginationSlice';
import filterReducer from '../slices/filterSlice';
import { configureStore } from '@reduxjs/toolkit';

export const store = configureStore({
  reducer: {
    characters: characterReducer,
    pagination: paginationReducer,
    filter: filterReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
