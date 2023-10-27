export type InitialStateFiltersType = {
  filterType: FilterType;
};

export type FilterPropsType = {
  filterType: FiltersEnum;
};

export type FilterType = {
  gender?: FiltersEnum.Gender;
  species?: FiltersEnum.Species;
  status?: FiltersEnum.Status;
  type?: FiltersEnum.Type;
};

export type FilterPayloadType = {
  filter: string;
  type: string;
};

export enum FiltersEnum {
  Gender = 'gender',
  Species = 'species',
  Status = 'status',
  Type = 'type',
}
