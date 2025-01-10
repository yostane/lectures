# Cours de Java

![ci workflow badge](https://github.com/yostane/cours-java/actions/workflows/ci.yml/badge.svg)

## Troubleshoot

settings.json

```json
{
  "markdownlint.config": {
    "default": true,
    "MD007": { "indent": 4 }
  },
  "spellright.language": ["English (American)", "French"],
  "spellright.documentTypes": ["markdown", "latex", "plaintext"],
  "yaml.schemas": {
    "https://squidfunk.github.io/mkdocs-material/schema.json": "mkdocs.yml"
  },
  "yaml.customTags": [
    "!ENV scalar",
    "!ENV sequence",
    "tag:yaml.org,2002:python/name:material.extensions.emoji.to_svg",
    "tag:yaml.org,2002:python/name:material.extensions.emoji.twemoji",
    "tag:yaml.org,2002:python/name:pymdownx.superfences.fence_code_format",
    "tag:yaml.org,2002:python/object/apply:pymdownx.slugs.slugify"
  ]
}
```
