// this is navbar developed by tailwindcss and jsx for react

import { Fragment } from "react";
import { Disclosure, Menu, Transition } from "@headlessui/react";
import { Link, useLocation } from "react-router-dom";
import navLogo from "../assets/HeracleLogoNav.png";
import { MagnifyingGlassIcon } from "@heroicons/react/24/solid";
import { Bars3Icon, XMarkIcon, MapPinIcon } from "@heroicons/react/24/outline";

function classNames(...classes) {
  return classes.filter(Boolean).join(" ");
}

function scrollToTop() {
  window.scrollTo({
    top: 0,
    behavior: "instant",
  });
}

export default function NavBar() {
  const location = useLocation();
  return (
    <Disclosure as='nav' className='bg-white shadow fixed w-full z-50'>
      {({ open }) => (
        <>
          <div className='mx-auto max-w-7xl px-2 sm:px-4 lg:px-8'>
            <div className='flex h-16 justify-between'>
              <div className='flex px-2 lg:px-0'>
                <div className='flex flex-shrink-0 items-center'>
                  <img
                    className='block h-8 w-auto lg:hidden'
                    src={navLogo}
                    alt='Heracle Logo'
                  />

                  <img
                    className='hidden h-8 w-auto lg:block'
                    src={navLogo}
                    alt='Heracle Logo'
                  />
                </div>
                <div className='hidden lg:ml-6 lg:flex lg:space-x-8'>
                  {/* Current: "border-indigo-500 text-gray-900", Default: "border-transparent text-gray-500 hover:border-gray-300 hover:text-gray-700" */}

                  <Link
                    onClick={() => scrollToTop()}
                    to='/Active-Wear'
                    // className='inline-flex items-center border-b-2 border-indigo-500 px-1 pt-1 text-sm font-medium text-gray-900'
                    className={`${
                      location.pathname === "/Active-Wear"
                        ? "inline-flex items-center border-b-2 border-indigo-500 px-1 pt-1 text-sm font-medium text-gray-900"
                        : "inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700"
                    }`}
                  >
                    Active Wear
                  </Link>
                  <Link
                    onClick={() => scrollToTop()}
                    to='/Our-Strength'
                    className={`${
                      location.pathname === "/Our-Strength"
                        ? "inline-flex items-center border-b-2 border-indigo-500 px-1 pt-1 text-sm font-medium text-gray-900"
                        : "inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700"
                    }`}
                  >
                    Our Strength
                  </Link>
                  <Link
                    onClick={() => scrollToTop()}
                    to='#'
                    className='inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700'
                  >
                    Materials
                  </Link>
                  <Link
                    onClick={() => scrollToTop()}
                    to='#'
                    className='inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700'
                  >
                    Wholesale
                  </Link>
                  <div className='inline-flex items-center border-b-2 border-transparent px-1 pt-1 text-sm font-medium text-gray-500 hover:border-gray-300 hover:text-gray-700'>
                    {/* More dropdown */}
                    <Menu as='div' className='relative flex-shrink-0'>
                      <div>
                        <Menu.Button className='flex rounded-full bg-white text-sm'>
                          <p>More</p>
                        </Menu.Button>
                      </div>
                      <Transition
                        as={Fragment}
                        enter='transition ease-out duration-100'
                        enterFrom='transform opacity-0 scale-95'
                        enterTo='transform opacity-100 scale-100'
                        leave='transition ease-in duration-75'
                        leaveFrom='transform opacity-100 scale-100'
                        leaveTo='transform opacity-0 scale-95'
                      >
                        <Menu.Items className='absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none'>
                          <Menu.Item>
                            {({ active }) => (
                              <Link
                                to='#'
                                className={classNames(
                                  active ? "bg-gray-100" : "",
                                  "block px-4 py-2 text-sm text-gray-700"
                                )}
                              >
                                Contact Us
                              </Link>
                            )}
                          </Menu.Item>
                          <Menu.Item>
                            {({ active }) => (
                              <Link
                                to='#'
                                className={classNames(
                                  active ? "bg-gray-100" : "",
                                  "block px-4 py-2 text-sm text-gray-700"
                                )}
                              >
                                Settings
                              </Link>
                            )}
                          </Menu.Item>
                        </Menu.Items>
                      </Transition>
                    </Menu>
                  </div>
                </div>
              </div>
              <div className='flex flex-1 items-center justify-center px-2 lg:ml-6 lg:justify-end'>
                <div className='w-full max-w-lg lg:max-w-xs'>
                  <label htmlFor='search' className='sr-only'>
                    Search
                  </label>
                  <div className='relative'>
                    <div className='pointer-events-none absolute inset-y-0 left-0 flex items-center pl-3'>
                      <MagnifyingGlassIcon
                        className='h-5 w-5 text-gray-400'
                        aria-hidden='true'
                      />
                    </div>
                    <input
                      id='search'
                      name='search'
                      className='block w-full rounded-full border border-gray-300 bg-white py-2 pl-10 pr-3 leading-5 placeholder-gray-500 focus:border-indigo-500 focus:placeholder-gray-400 focus:outline-none focus:ring-1 focus:ring-indigo-500 sm:text-sm'
                      placeholder='Search'
                      type='search'
                    />
                  </div>
                </div>
                <div className='hidden lg:block'>
                  <Link
                    to='#'
                    className='flex items-center space-x-3 ml-4 lg:ml-6'
                  >
                    <MapPinIcon
                      className='h-6 w-6 text-gray-400'
                      aria-hidden='true'
                    />
                    <span className='text-gray-500 text-sm font-medium'>
                      Locate Store
                    </span>
                  </Link>
                </div>
              </div>
              <div className='flex items-center lg:hidden'>
                {/* Mobile menu button */}
                <Disclosure.Button className='inline-flex items-center justify-center rounded-md p-2 text-gray-400 hover:bg-gray-100 hover:text-gray-500 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500'>
                  <span className='sr-only'>Open main menu</span>
                  {open ? (
                    <XMarkIcon className='block h-6 w-6' aria-hidden='true' />
                  ) : (
                    <Bars3Icon className='block h-6 w-6' aria-hidden='true' />
                  )}
                </Disclosure.Button>
              </div>
            </div>
          </div>

          <Disclosure.Panel className='lg:hidden'>
            <div className='space-y-1 pt-2 pb-3'>
              {/* Current: "bg-indigo-50 border-indigo-500 text-indigo-700", Default: "border-transparent text-gray-600 hover:bg-gray-50 hover:border-gray-300 hover:text-gray-800" */}
              <Link
                onClick={() => scrollToTop()}
                to='/Active-Wear'
                className={`${
                  location.pathname === "/Active-Wear"
                    ? "block border-l-4 border-indigo-500 bg-indigo-50 py-2 pl-3 pr-4 text-base font-medium text-indigo-700"
                    : "block border-l-4 border-transparent py-2 pl-3 pr-4 text-base font-medium text-gray-600 hover:border-gray-300 hover:bg-gray-50 hover:text-gray-800"
                }`}
              >
                Active Wear
              </Link>
              <Link
                onClick={() => scrollToTop()}
                to='/Our-Strength'
                className={`${
                  location.pathname === "/Our-Strength"
                    ? "block border-l-4 border-indigo-500 bg-indigo-50 py-2 pl-3 pr-4 text-base font-medium text-indigo-700"
                    : "block border-l-4 border-transparent py-2 pl-3 pr-4 text-base font-medium text-gray-600 hover:border-gray-300 hover:bg-gray-50 hover:text-gray-800"
                }`}
              >
                Our Strength
              </Link>
              <Link
                onClick={() => scrollToTop()}
                to='#'
                className={`${
                  location.pathname === "#"
                    ? "block border-l-4 border-indigo-500 bg-indigo-50 py-2 pl-3 pr-4 text-base font-medium text-indigo-700"
                    : "block border-l-4 border-transparent py-2 pl-3 pr-4 text-base font-medium text-gray-600 hover:border-gray-300 hover:bg-gray-50 hover:text-gray-800"
                }`}
              >
                Materials
              </Link>
              <Link
                onClick={() => scrollToTop()}
                to='#'
                className={`${
                  location.pathname === "#"
                    ? "block border-l-4 border-indigo-500 bg-indigo-50 py-2 pl-3 pr-4 text-base font-medium text-indigo-700"
                    : "block border-l-4 border-transparent py-2 pl-3 pr-4 text-base font-medium text-gray-600 hover:border-gray-300 hover:bg-gray-50 hover:text-gray-800"
                }`}
              >
                Wholesale
              </Link>
              <Link
                onClick={() => scrollToTop()}
                to='#'
                className={`${
                  location.pathname === "#"
                    ? "block border-l-4 border-indigo-500 bg-indigo-50 py-2 pl-3 pr-4 text-base font-medium text-indigo-700"
                    : "block border-l-4 border-transparent py-2 pl-3 pr-4 text-base font-medium text-gray-600 hover:border-gray-300 hover:bg-gray-50 hover:text-gray-800"
                }`}
              >
                Contact Us
              </Link>
              <Link
                onClick={() => scrollToTop()}
                to='#'
                className={`${
                  location.pathname === "#"
                    ? "block border-l-4 border-indigo-500 bg-indigo-50 py-2 pl-3 pr-4 text-base font-medium text-indigo-700"
                    : "block border-l-4 border-transparent py-2 pl-3 pr-4 text-base font-medium text-gray-600 hover:border-gray-300 hover:bg-gray-50 hover:text-gray-800"
                }`}
              >
                Settings
              </Link>
              <Link
                onClick={() => scrollToTop()}
                to='#'
                className='block border-l-4 border-transparent py-2 pl-1 pr-4 text-base font-medium text-gray-600 hover:border-gray-300 hover:bg-gray-50 hover:text-gray-800'
              >
                <div className='flex'>
                  <MapPinIcon
                    className='h-6 w-6 text-gray-400'
                    aria-hidden='true'
                  />
                  <p className='pl-2'>Locate Store</p>
                </div>
              </Link>
            </div>
          </Disclosure.Panel>
        </>
      )}
    </Disclosure>
  );
}
