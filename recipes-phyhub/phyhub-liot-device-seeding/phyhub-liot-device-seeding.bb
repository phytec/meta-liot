DESCRIPTION = "Initial data for snapdata partition"
HOMEPAGE = "https://github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " \
    git://github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding.git;branch=main;protocol=https \
"

SRCREV = "bf9a307446203b151a1155a096d513a047ee2d6f"

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
