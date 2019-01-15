from setuptools import setup, find_packages

setup(name='flip',
      version='1.0.0',
      description='Flip a coin.',
      author='Raphael Zaafrani and Conor Murphy',
      author_email='rizaafrani@pipeline.sbcc.edu, ctmurphy@pipeline.sbcc.edu',
      packages=find_packages(),
      entry_points={
          'console_scripts': ['flip=flip.__main__:main'],
      },
      license="AGPL-3.0-or-later",
      zip_safe=False)
