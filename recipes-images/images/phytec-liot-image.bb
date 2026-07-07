require recipes-images/images/phytec-headless-image.bb

PARTUP_LAYOUT_CONFIG:update = "layout-liot.yaml"

IMAGE_INSTALL:append = " \
    packagegroup-snapd \
    phyhub-liot-device-provisioning \
"
IMAGE_INSTALL:remove = " \
    rauc-downgrade-barrier \
"

PARTUP_PACKAGE_FILES:append = " phyhub-liot-device-seeding.tar.gz"
PARTUP_PACKAGE_DEPENDS:append = " phyhub-liot-device-seeding"
