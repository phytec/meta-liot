DESCRIPTION = "Initial data for snapdata partition"
HOMEPAGE = "https://github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding"
LICENSE = "CLOSED"

SRC_URI = " \
    git://git@github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding.git;branch=main;protocol=ssh \
"

SRCREV = "467495cbc7552c17b094f10371bd3112ef0662d7"

inherit deploy
S = "${WORKDIR}"

do_install () {
        mkdir -p ${D}/var/lib/snapd/seed
        cp -r ${S}/git/${MACHINE}/seed/* ${D}/var/lib/snapd/seed
}

FILES:${PN} = "var/"

do_deploy () {
        tar -czf ${B}/phyhub-liot-device-seeding.tar.gz -C ${D}/ . --owner=0 --group=0
        install -m 644 ${B}/phyhub-liot-device-seeding.tar.gz ${DEPLOYDIR}
}

addtask deploy after do_install
