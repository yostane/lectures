import PortfolioItem from "../components/PortfolioItem";

export default function Portfolio() {
  const portfolioItems = [
    { title: "Java", description: "Langage Java" },
    {
      title: "Desktop dev",
      description: "Développement d'applications de bureau",
    },
    {
      title: "React",
      description: "Développement front avec ReactJS",
    },
  ];

  const portfolioItemsElements = portfolioItems.map((portfolioItem) => (
    <PortfolioItem
      title={portfolioItem.title}
      description={portfolioItem.description}
    />
  ));

  return (
    <>
      <div class="portfolio-container">{portfolioItemsElements}</div>
    </>
  );
}
