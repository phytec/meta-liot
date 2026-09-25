SUMMARY = "A device provisioning tool that runs before the user login"
DESCRIPTION = "A device provisioning tool that runs before the user login. It \
collects the device's hardware facts (machine-id, platform identifiers, TPM, \
Secure Boot status, MAC addresses, …) and hands them to the local snapd, which \
then registers the device with the L-IoT Appstore."
HOMEPAGE = "https://github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-provisioning"

LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/src/${BPN}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " \
    git://git@github.com/ML-PA-Consulting-GmbH/${BPN}.git;branch=main;protocol=ssh \
    file://${BPN}-${FLOW}.service \
"
SRCREV = "f34cd4c015c852b77e6db9fb12b83113077869d0"

GO_IMPORT = "${BPN}"
GO_EXTRA_LDFLAGS = "-X main.version=${PV}"

do_compile[network] = "1"

FLOW = "claiming-token"
#FLOW = "basic"

SYSTEMD_SERVICE:${PN} = "${BPN}-${FLOW}.service"

inherit go-mod systemd

do_install:append (){
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}-${FLOW}.service ${D}${systemd_system_unitdir}

    mv ${D}${bindir}/phyhub-liot-device-provisioning ${D}${bindir}/liot-provisioning
}

FILES:${PN} += "${systemd_system_unitdir}"

RDEPENDS:${PN} += "snapd"
