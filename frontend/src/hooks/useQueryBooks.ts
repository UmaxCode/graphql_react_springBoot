import { useQuery, gql } from "@apollo/client";

const useQueryBooks = (query: string) => {
  return useQuery(gql(query));
};

export default useQueryBooks;
