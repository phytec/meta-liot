require recipes-images/images/phytec-headless-image.bb

PARTUP_LAYOUT_CONFIG:update = "layout-liot.yaml"

IMAGE_INSTALL:append = " packagegroup-snapd"
