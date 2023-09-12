<script>
    import { onMount } from "svelte";

    import Card from "./lib/components/CardProxy.svelte";

    let cardToShow = null;
    let isLoading = true;

    const getCards = async () => {
        let cardFetch = await fetch("/data/cards.json");
        let cards = await cardFetch.json();
        return cards;
    };

    const loadCards = async () => {
        return getCards()
            .then((cards) => {
                window["cards"] = cards;
                // Find the card with the specified "id"
                cardToShow = cards.find(card => card.id === "1");
                isLoading = false;
            });
    };

    onMount(() => {
        loadCards();
        const $headings = document.querySelectorAll("h1,h2,h3");
        const $anchor = [...$headings].filter((el) => {
            const id = el.getAttribute("id")?.replace(/^.*?-/g, "");
            const hash = window.location.hash?.replace(/^.*?-/g, "")
            return id === hash;
        })[0];
        if ($anchor) {
            setTimeout(() => {
                $anchor.scrollIntoView();
            }, 100);
        }
    });
</script>

<main>
    {#if cardToShow !== null}
        <Card
                id={cardToShow.id}
                name={cardToShow.name}
                img={cardToShow.images.large}
                number={cardToShow.number}
                types={cardToShow.types}
                supertype={cardToShow.supertype}
                subtypes={cardToShow.subtypes}
        />
    {:else if isLoading}
        loading...
    {/if}
</main>

