import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import { sveltrisVitePlugins } from "sveltris";
import { svelte } from "@sveltejs/vite-plugin-svelte";

export default defineConfig({
  plugins: [
    react(),
    ...sveltrisVitePlugins(),
    svelte({ compilerOptions: { hydratable: true } }),
  ],
});