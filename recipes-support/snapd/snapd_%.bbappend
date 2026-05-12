SRC_URI:append = " \
    git://git@github.com/ML-PA-Consulting-GmbH/phyhub-liot-device-seeding.git;branch=main;protocol=ssh;name=seed \
"

SRCREV_seed = "467495cbc7552c17b094f10371bd3112ef0662d7"

copy_constants_go () {
    cp ${S}/src/github.com/snapcore/snapd/phyboard-pollux-imx8mp-3/constants.go ${S}/constants/constants.go
}

python do_patch:append () {
    bb.build.exec_func("copy_constants_go", d)
}
