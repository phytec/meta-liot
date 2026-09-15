DESCRIPTION = "Initial data for snapdata partition"
HOMEPAGE = "https://github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding"
LICENSE = "CLOSED"

SRC_URI = " \
    git://git@github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding.git;branch=main;protocol=ssh \
"

SRCREV = "77097569bfb07ac70a9d3afee6e009d02eed87e2"

PACKAGES += "${PN}-link"

inherit deploy
S = "${WORKDIR}"

C = "${WORKDIR}/seed-part"

do_compile[cleandirs] = "${C}"

do_compile () {
        mkdir -p ${C}/var/lib/snapd/seed
        cp -r ${S}/git/phyhub-production-environment/seeds/seed-${MACHINE}/seed/* ${C}/var/lib/snapd/seed
}

do_install () {
        install -d "${D}"
        ln -sf /var/lib/snapd/snap ${D}/snap
}

FILES:${PN}-link = "snap"

do_deploy () {
        tar -czf ${B}/phyhub-liot-device-seeding.tar.gz -C ${C}/ . --owner=0 --group=0
        install -m 644 ${B}/phyhub-liot-device-seeding.tar.gz ${DEPLOYDIR}
}

addtask deploy after do_compile
