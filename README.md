# meta-liot

Yocto layer for the L.IoT platform.

The layer contains all the tools to connect your Yocto device to the L.IoT
platform.

## Dependencies

- URI: https://git.openembedded.org/openembedded-core
  - branch: scarthgap
  - revision: HEAD

## Branches

| Branch          | Yocto Release |
|-----------------|---------------|
| scarthgap       | 5.0 (scarthgap) |
| scarthgap-next  | 5.0 (scarthgap, development) |
| master          | next release (development) |

## Usage

Add this layer to your `bblayers.conf`:

```
BBLAYERS += "/path/to/meta-liot"
```

## License

All metadata is MIT licensed unless otherwise stated.
See `LICENSE.MIT` for the full license text.
