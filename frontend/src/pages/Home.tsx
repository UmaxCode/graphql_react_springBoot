import useQueryBooks from "../hooks/useQueryBooks";
const GET_BOOKS = `
query getAllBooks{
  getBooks {
    id,
    title,
    pageCount,
  }
}
`;
const Home = () => {
  const { loading, error, data } = useQueryBooks(GET_BOOKS);

  console.log({
    loading,
    error,
    data,
  });

  if (loading) {
    return <h1>loading...</h1>;
  }

  if (error) {
    return <h1>{error.message}</h1>;
  }

  return (
    <>
      <h1 className="bg-red-300 text-white p-3 text-xl text-center">
        welcome to GraphQL
      </h1>
      <div className=" max-w-md mx-auto">
        <ul className="">
          {data.getBooks.map(
            (book: { id: string; title: string; pageCount: number }) => (
              <li key={book.id} className="border flex gap-4">
                <h1>title: {book.title}</h1>
                <h1>title: {book.pageCount}</h1>
              </li>
            )
          )}
        </ul>
      </div>
    </>
  );
};

export default Home;
