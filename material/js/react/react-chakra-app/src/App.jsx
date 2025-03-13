import "./App.css";
import { RadioCard, HStack } from "@chakra-ui/react";

export default function App() {
  const items = [
    { value: "next", title: "Next.js" },
    { value: "vite", title: "Vite" },
    { value: "astro", title: "Astro" },
  ];

  return (
    <>
      <RadioCard.Root defaultValue="next">
        <RadioCard.Label>Select framework</RadioCard.Label>
        <HStack align="stretch">
          {items.map((item) => (
            <RadioCard.Item key={item.value} value={item.value}>
              <RadioCard.ItemHiddenInput />
              <RadioCard.ItemControl>
                <RadioCard.ItemText>{item.title}</RadioCard.ItemText>
                <RadioCard.ItemIndicator />
              </RadioCard.ItemControl>
            </RadioCard.Item>
          ))}
        </HStack>
      </RadioCard.Root>
    </>
  );
}
